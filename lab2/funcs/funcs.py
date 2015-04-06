def map(func, list):
	retlist = []
	for item in list:
		retlist.append(func(item))
	return retlist

def add(x):
	def g(y):
		return x + y
	return g

def create_counter(start):
	d = {'val':start}

	def counter():
		retval = d['val']
		d['val'] += 1
		return retval

	return counter