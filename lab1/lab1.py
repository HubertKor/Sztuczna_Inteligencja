import pandas as pd
import numpy as np

# Zadanie 3

data = pd.read_csv(
    "diabetes.txt",
    sep=" ",
    header=None,
    names=["a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"]
)

unique_labels = data["a9"].unique()
num_samples = len(data)
max_values = data.max(axis=0)
min_values = data.min(axis=0)
num_unique_values = data.nunique()

print("Unique Labels:", unique_labels)
print("Number of Samples:", num_samples)
print("Max Values:\n", max_values)
print("\nMin Values:\n", min_values)
print("Number of Unique Values:\n", num_unique_values)
print()

for col in data.columns:
    unique_values = list(data[col].unique())
    print(f"{col} unique values:", unique_values)

print("\nStandard Deviations:\n", data.std())

# Zadanie 4

fraction_unknown = 0.1
num_unknown = int(fraction_unknown * num_samples)
means = data.mean()
new_data = {col: [means[col]] * num_unknown for col in data.columns}
new_df = pd.DataFrame(new_data)

data = pd.concat([data, new_df], ignore_index=False)

print("Length after adding unknown data:", len(data))

def normalize(attribute, a, b):
    min_val = attribute.min()
    max_val = attribute.max()
    normalized = a + ((attribute - min_val) * (b - a)) / (max_val - min_val)
    return normalized

intervals = {
    "<-1, 1>": (-1, 1),
    "<0, 1>": (0, 1),
    "<-10, 10>": (-10, 10)
}

normalized_data = pd.DataFrame()

for col in data.columns:
    if data[col].dtype == 'float64' or data[col].dtype == 'int64':
        for interval_name, interval_range in intervals.items():
            normalized_col = normalize(data[col], *interval_range)
            normalized_data[f'{col}_{interval_name}'] = normalized_col

print(normalized_data)

standardized_data = pd.DataFrame()

for col in data.columns:
    if data[col].dtype == 'float64' or data[col].dtype == 'int64':
        mean_val = data[col].mean()
        std_dev = data[col].std()
        standardized_col = (data[col] - mean_val) / std_dev
        standardized_data[col] = standardized_col

print("Standardized Data:\n", standardized_data.head())

# Zadanie 5

churn = pd.read_csv("Churn_Modelling.csv")
print("Original Columns:", churn.columns)
churn = pd.get_dummies(churn, columns=["Geography"], drop_first=True)
print("Columns after One-Hot Encoding:", churn.columns)
