import torch
import json
from sklearn.feature_extraction.text import CountVectorizer

# Cargar modelo y metadatos
with open("model_metadata.json") as f:
    metadata = json.load(f)

vectorizer = metadata["vectorizer"]
model = torch.load("model_network.pth")
model.eval()

# Input del usuario
text = input("Write something: ")
features = vectorizer.transform([text]).toarray()
prediction = model(torch.tensor(features, dtype=torch.long))
predicted_label = torch.argmax(prediction, dim=1).item()

if predicted_label == 1:
    print("This is English")
else:
    print("I don't understand you")
