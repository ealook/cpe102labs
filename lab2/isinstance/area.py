import math
from classes import *

def area(shape):
	if isinstance(shape, Circle):
		return (shape.radius ** 2) * math.pi
	elif isinstance(shape, Square):
		return shape.side ** 2
	elif isinstance(shape, Rectangle):
		return shape.width * shape.height
	else:
		raise TypeError