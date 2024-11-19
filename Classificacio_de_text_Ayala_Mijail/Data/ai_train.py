import json
import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import DataLoader, Dataset
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer

# Dataset customizado
class TextDataset(Dataset):
    def __init__(self, texts, labels):
        self.texts = texts
        self.labels = labels

    def __len__(self):
        return len(self.texts)

    def __getitem__(self, idx):
        return self.texts[idx], self.labels[idx]

# Modelo simple
class TextClassifier(nn.Module):
    def __init__(self, input_dim, embedding_dim, hidden_dim, output_dim):
        super(TextClassifier, self).__init__()
        self.embedding = nn.EmbeddingBag(input_dim, embedding_dim, sparse=True)
        self.fc = nn.Sequential(
            nn.Linear(embedding_dim, hidden_dim),
            nn.ReLU(),
            nn.Linear(hidden_dim, output_dim)
        )

    def forward(self, text):
        embedded = self.embedding(text)
        return self.fc(embedded)

# Cargar configuración
with open("model_config.json") as f:
    config = json.load(f)

# Leer datos
data = pd.read_csv('./data/engorother.csv')
vectorizer = CountVectorizer()
X = vectorizer.fit_transform(data['phrase']).toarray()
y = (data['label'] == 'eng').astype(int).values

# Dividir en entrenamiento y validación
X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

# Crear datasets y dataloaders
train_dataset = TextDataset(torch.tensor(X_train, dtype=torch.long), torch.tensor(y_train, dtype=torch.long))
val_dataset = TextDataset(torch.tensor(X_val, dtype=torch.long), torch.tensor(y_val, dtype=torch.long))
train_loader = DataLoader(train_dataset, batch_size=config["batch_size"], shuffle=True)
val_loader = DataLoader(val_dataset, batch_size=config["batch_size"], shuffle=False)

# Configurar modelo
model = TextClassifier(
    input_dim=X.shape[1],
    embedding_dim=config["embedding_dim"],
    hidden_dim=config["hidden_dim"],
    output_dim=config["output_dim"]
)

# Entrenar modelo
criterion = nn.CrossEntropyLoss()
optimizer = optim.Adam(model.parameters(), lr=config["learning_rate"])

for epoch in range(config["num_epochs"]):
    model.train()
    total_loss = 0
    for texts, labels in train_loader:
        optimizer.zero_grad()
        outputs = model(texts)
        loss = criterion(outputs, labels)
        loss.backward()
        optimizer.step()
        total_loss += loss.item()
    print(f"Epoch {epoch+1}/{config['num_epochs']}, Loss: {total_loss:.4f}")

# Guardar modelo
torch.save(model.state_dict(), "model_network.pth")
metadata = {"vectorizer": vectorizer, "input_dim": X.shape[1]}
with open("model_metadata.json", "w") as f:
    json.dump(metadata, f)
