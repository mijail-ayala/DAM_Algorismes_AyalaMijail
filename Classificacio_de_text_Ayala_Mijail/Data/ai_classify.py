import torch
import random
import pandas as pd
import json
from sklearn.feature_extraction.text import CountVectorizer

# Cargar modelo y metadatos
with open("model_metadata.json") as f:
    metadata = json.load(f)

vectorizer = metadata["vectorizer"]
model = torch.load("model_network.pth")
model.eval()

# Cargar datos y seleccionar textos aleatorios
data = pd.read_csv('./data/sentiments.csv')
samples = data.sample(50)
texts = samples['phrase']

# Clasificar textos
correct = 0
for text in texts:
    features = vectorizer.transform([text]).toarray()
    prediction = model(torch.tensor(features, dtype=torch.long))
    predicted_label = torch.argmax(prediction, dim=1).item()
    true_label = 1 if text['label'] == 'eng' else 0
    correct += (predicted_label == true_label)
    print(f"Text: {text}, Prediction: {predicted_label} = {'eng' if predicted_label == 1 else 'other'}")

accuracy = correct / len(samples)
print(f"Accuracy: {accuracy:.2%}")
