import unittest
from MatrixMultiplication import MatrixMultiplication as MM

class TestCases(unittest.TestCase):
	def testcase1(self):
		matrix_instance = MM(0)
		matrix = [[1,2,3],[3,1,2],[2,3,1]]
		power = 8
		answer = [[559845,559845,559926],[559926,559845,559845],[559845,559926,559845]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertEqual(matrix_instance.counter,3)

	def testcase2(self):
		matrix_instance = MM(0)
		matrix = [[2,4,3,1],[3,1,4,2],[4,6,5,3],[6,2,4,1]]
		power = 5
		answer = [[74630,75352,86627,40639],[79675,80413,92506,43394],[133992,135322,155513,72949],[95722,96590,111172,52153]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertEqual(matrix_instance.counter,3)

	def testcase3(self):
		matrix_instance = MM(0)
		matrix = [[1,2],[2,1]]
		power = 10
		answer = [[29525,29524],[29524,29525]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertEqual(matrix_instance.counter,4)

	def testcase4(self):
		matrix_instance = MM(0)
		matrix = [[1,2,1,2,1,2],[2,1,2,1,2,1],[1,2,1,2,1,2],[2,1,2,1,2,1],[1,2,1,2,1,2],[2,1,2,1,2,1]]
		power = 4
		answer = [[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107],[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107],[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertEqual(matrix_instance.counter,2)

	def testcase5(self):
		matrix_instance = MM(0)
		matrix = [[1,2,3],[3,2,1],[2,1,3]]
		power = 7
		answer = [[90560,74104,115272],[90576,74104,115256],[90568,74096,115272]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertEqual(matrix_instance.counter,3)

if __name__ == '__main__':
    unittest.main()