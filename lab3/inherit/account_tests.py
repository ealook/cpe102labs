import unittest
import account

class TestCases(unittest.TestCase):
   def test_account_1(self):
      savings = account.Account(1000)
      self.assertEqual(savings.getBalance(), 1000)


   def test_account_2(self):
      savings = account.Account(1000)
      self.assertEqual(savings.getBalance(), 1000)
      savings.purchaseItem(20)
      self.assertEqual(savings.getBalance(), 980)


   def test_account_3(self):
      savings = account.Account(1000)
      self.assertEqual(savings.getBalance(), 1000)
      savings.returnItem(20)
      self.assertEqual(savings.getBalance(), 1020)

   def test_premium_1(self):
      savings = account.PremiumAccount(1000)
      self.assertEqual(savings.getBalance(), 1000)


   def test_premium_2(self):
      savings = account.PremiumAccount(1000)
      self.assertEqual(savings.getBalance(), 1000)
      savings.purchaseItem(20)
      self.assertEqual(savings.getBalance(), 982)


   def test_premium_3(self):
      savings = account.PremiumAccount(1000)
      self.assertEqual(savings.getBalance(), 1000)
      savings.returnItem(20)
      self.assertEqual(savings.getBalance(), 1018)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

