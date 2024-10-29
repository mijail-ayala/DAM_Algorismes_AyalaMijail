import numpy as np
import random

# Función para generar todas las matrices posibles
def generate_all_matrices():
    matrices = []
    for i in range(512):
        binary = format(i, '09b')
        matrix = [int(bit) for bit in binary]
        matrices.append(matrix)
    return matrices

# Clase Perceptrón
class Perceptron:
    def __init__(self, weights, bias=0):
        self.weights = np.array(weights)
        self.bias = bias
    
    def predict(self, inputs):
        total_activation = np.dot(inputs, self.weights) + self.bias
        return 1 if total_activation >= 0 else 0
    
    def train(self, training_data, labels, epochs=100, learning_rate=0.1):
        for _ in range(epochs):
            for inputs, label in zip(training_data, labels):
                prediction = self.predict(inputs)
                error = label - prediction
                self.weights += learning_rate * error * np.array(inputs)
                self.bias += learning_rate * error

# Función para etiquetar matrices con patrones específicos
def label_matrices(matrices, pattern_type):
    labels = []
    for matrix in matrices:
        if pattern_type == 'diagonal':
            labels.append(1 if (matrix[0] == matrix[4] == matrix[8] == 1) or (matrix[2] == matrix[4] == matrix[6] == 1) else 0)
        elif pattern_type == 'vertical':
            labels.append(1 if (matrix[0] == matrix[3] == matrix[6] == 1) or (matrix[1] == matrix[4] == matrix[7] == 1) or (matrix[2] == matrix[5] == matrix[8] == 1) else 0)
        elif pattern_type == 'horizontal':
            labels.append(1 if (matrix[0] == matrix[1] == matrix[2] == 1) or (matrix[3] == matrix[4] == matrix[5] == 1) or (matrix[6] == matrix[7] == matrix[8] == 1) else 0)
    return labels

# Función para evaluar la precisión de un perceptrón
def evaluate_perceptron(perceptron, matrices, labels):
    correct_predictions = sum(perceptron.predict(matrix) == label for matrix, label in zip(matrices, labels))
    accuracy = correct_predictions / len(labels)
    return accuracy * 100

# Main para entrenar y evaluar los perceptrones
if __name__ == "__main__":
    matrices = generate_all_matrices()
    
    # Perceptrones para detectar patrones
    perceptron_diagonal = Perceptron(weights=[random.uniform(-1, 1) for _ in range(9)], bias=random.uniform(-1, 1))
    perceptron_vertical = Perceptron(weights=[random.uniform(-1, 1) for _ in range(9)], bias=random.uniform(-1, 1))
    perceptron_horizontal = Perceptron(weights=[random.uniform(-1, 1) for _ in range(9)], bias=random.uniform(-1, 1))
    
    # Etiquetado de matrices
    labels_diagonal = label_matrices(matrices, 'diagonal')
    labels_vertical = label_matrices(matrices, 'vertical')
    labels_horizontal = label_matrices(matrices, 'horizontal')
    
    # Entrenamiento y evaluación de cada perceptrón
    epochs_list = [10, 50, 100, 200, 500]
    for epochs in epochs_list:
        # Entrenar cada perceptrón
        perceptron_diagonal.train(matrices, labels_diagonal, epochs=epochs)
        perceptron_vertical.train(matrices, labels_vertical, epochs=epochs)
        perceptron_horizontal.train(matrices, labels_horizontal, epochs=epochs)
        
        # Evaluar precisión de cada perceptrón
        accuracy_diagonal = evaluate_perceptron(perceptron_diagonal, matrices, labels_diagonal)
        accuracy_vertical = evaluate_perceptron(perceptron_vertical, matrices, labels_vertical)
        accuracy_horizontal = evaluate_perceptron(perceptron_horizontal, matrices, labels_horizontal)
        
        # Imprimir resultados
        print(f"Epochs: {epochs}")
        print(f"Perceptron Diagonal Accuracy: {accuracy_diagonal:.2f}%")
        print(f"Perceptron Vertical Accuracy: {accuracy_vertical:.2f}%")
        print(f"Perceptron Horizontal Accuracy: {accuracy_horizontal:.2f}%")
        print("-" * 40)

        # Verificar fiabilidad
        if accuracy_diagonal > 50 and accuracy_vertical > 50 and accuracy_horizontal > 50:
            print(f"Tots tres perceptrons tenen una fiabilitat superior al 50% després de {epochs} epochs.")
        if accuracy_diagonal > 80 and accuracy_vertical > 80 and accuracy_horizontal > 80:
            print(f"Tots tres perceptrons tenen una fiabilitat superior al 80% després de {epochs} epochs.")
