import numpy as np
from scipy.stats import linregress
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation

years = np.array([2000, 2002, 2005, 2007, 2010])
percentages = np.array([6.5, 7.0, 7.4, 8.2, 9.0])

slope, intercept, r_value, p_value, std_err = linregress(years, percentages)


def predict_percentage(year):
    return slope * year + intercept


# zad1
year_2012_prediction = predict_percentage(2012)
print("Przewidywany procent bezrobotnych w roku 2012:", round(year_2012_prediction, 3))

# zad2
target_percentage = 12
target_year = (target_percentage - intercept) / slope
print("Rok, w którym procent przekroczy 12%:", round(target_year))

# zad3
fig, ax = plt.subplots()
ax.scatter(years, percentages)
line, = ax.plot([], [], lw=2)


def init():
    line.set_data([], [])
    return line,


def animate(i):
    x = np.linspace(1998, 2012, 1000)
    y = slope_vals[i] * x + intercept_vals[i]
    line.set_data(x, y)
    return line,


slope_vals = np.linspace(slope - std_err, slope + std_err, 10)
intercept_vals = (percentages - slope_vals[:, np.newaxis] * years).mean(axis=1)

ani = FuncAnimation(fig, animate, frames=len(slope_vals), init_func=init, blit=True, interval=200)

plt.show()