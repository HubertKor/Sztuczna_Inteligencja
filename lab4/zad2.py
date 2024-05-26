import numpy as np


def perceptron_learn(perceptron, examples, alpha):
    weights = np.array(perceptron)
    while True:
        error_count = 0
        for x, y in examples:
            x = np.array(x)
            prediction = np.dot(weights, x)
            if prediction >= 0:
                prediction = 1
            else:
                prediction = 0
            error = y - prediction
            if error != 0:
                weights += alpha * error * x
                error_count += 1
        if error_count == 0:
            break
    return weights


def logic_function(x1, x2):
    return x1 and not x2


examples = [
    ([1, 0, 0], 0),
    ([1, 0, 1], 0),
    ([1, 1, 0], 1),
    ([1, 1, 1], 0)
]
initial_weights = [0.5, 0.5, 0.5]
alpha = 0.5

trained_weights = perceptron_learn(initial_weights, examples, alpha)

for x, _ in examples:
    x = np.array(x)
    prediction = np.dot(trained_weights, x)
    if prediction >= 0:
        prediction = 1
    else:
        prediction = 0
    print(f"Wejście: {x[1:]}, Predykcja: {prediction}")
print("Wytrenowane wagi:", trained_weights)