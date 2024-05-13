import unittest
from app import app

class TestCalculator(unittest.TestCase):
    def setUp(self):
        app.testing = True
        self.app = app.test_client()

    def test_addition(self):
        response = self.app.get('/add?a=10&b=5')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json['result'], 15)

    def test_subtraction(self):
        response = self.app.get('/subtract?a=10&b=5')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json['result'], 5)

    def test_multiplication(self):
        response = self.app.get('/multiply?a=10&b=5')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json['result'], 50)

    def test_division(self):
        response = self.app.get('/divide?a=10&b=5')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json['result'], 2)

    def test_division_by_zero(self):
        response = self.app.get('/divide?a=10&b=0')
        self.assertEqual(response.status_code, 200)
        self.assertIn('error', response.json)
        self.assertEqual(response.json['error'], 'Cannot divide by zero.')

if __name__ == '__main__':
    unittest.main()