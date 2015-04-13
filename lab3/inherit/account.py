
class Account(object):
   def __init__(self, initial):
      self.balance = initial

   def getBalance(self):
      return self.balance

   def purchaseItem(self, item_cost):
      self.balance -= item_cost

   def returnItem(self, item_cost):
      self.balance += item_cost

class PremiumAccount(Account):
	def __init__(self, initial):
		super(PremiumAccount, self).__init__(initial)

	def purchaseItem(self, item_cost):
		self.balance -= item_cost * 0.9

	def returnItem(self, item_cost):
		self.balance += item_cost * 0.9