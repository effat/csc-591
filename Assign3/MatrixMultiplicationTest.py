import unittest
from MatrixMultiplication import MatrixMultiplication as MM

class TestCases(unittest.TestCase):
	def testcase1(self):
		matrix_instance = MM(0)
		matrix = [[1,2,3],[3,1,2],[2,3,1]]
		power = 8
		answer = [[559845,559845,559926],[559926,559845,559845],[559845,559926,559845]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=6)

	def testcase2(self):
		matrix_instance = MM(0)
		matrix = [[2,4,3,1],[3,1,4,2],[4,6,5,3],[6,2,4,1]]
		power = 5
		answer = [[74630,75352,86627,40639],[79675,80413,92506,43394],[133992,135322,155513,72949],[95722,96590,111172,52153]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=6)

	def testcase3(self):
		matrix_instance = MM(0)
		matrix = [[1,2],[2,1]]
		power = 10
		answer = [[29525,29524],[29524,29525]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=8)

	def testcase4(self):
		matrix_instance = MM(0)
		matrix = [[1,2,1,2,1,2],[2,1,2,1,2,1],[1,2,1,2,1,2],[2,1,2,1,2,1],[1,2,1,2,1,2],[2,1,2,1,2,1]]
		power = 4
		answer = [[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107],[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107],[1107,1080,1107,1080,1107,1080],[1080,1107,1080,1107,1080,1107]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=4)

	def testcase5(self):
		matrix_instance = MM(0)
		matrix = [[1,2,3],[3,2,1],[2,1,3]]
		power = 7
		answer = [[90560,74104,115272],[90576,74104,115256],[90568,74096,115272]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=6)

	def testcase6(self):
		matrix_instance = MM(0)
		matrix = [[1,0,0],[0,-1,0],[0,0,1]]
		power = 85
		answer = [[1,0,0],[0,-1,0],[0,0,1]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=14)

	def testcase7(self):
		matrix_instance = MM(0)
		matrix = [[0,0,0,1],[0,0,-1,0],[0,1,0,0],[-1,0,0,0]]
		power = 99
		answer = [[0,0,0,-1],[0,0,1,0],[0,-1,0,0],[1,0,0,0]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=14)

	def testcase8(self):
		matrix_instance = MM(0)
		matrix = [[1,0,0],[0,-1,0],[0,0,1]]
		power = 64
		answer = [[1,0,0],[0,1,0],[0,0,1]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=12)

	def testcase9(self):
		matrix_instance = MM(0)
		matrix = [[1,0,0,0,0,0,0,0],[0,-1,0,0,0,0,0,0],[0,0,1,0,0,0,0,0],[0,0,0,-1,0,0,0,0],[0,0,0,0,1,0,0,0],[0,0,0,0,0,-1,0,0],[0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,-1]]
		power = 48
		answer = [[1,0,0,0,0,0,0,0],[0,1,0,0,0,0,0,0],[0,0,1,0,0,0,0,0],[0,0,0,1,0,0,0,0],[0,0,0,0,1,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,1]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=12)

	def testcase10(self):
		matrix_instance = MM(0)
		matrix = [[1, 3, 5, 6],[9, 3, 5, 7],[8, 7, 9, 11],[2, 3, 6, 0]]
		power = 4
		answer = [[35229, 30095, 46535, 42924],[49745, 42451, 65518, 61022],[77612, 66171, 102160, 94776],[31948, 27031, 41515, 39009 ]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=4)

	def testcase11(self):
		matrix_instance = MM(0)
		matrix = [[1, 3, 5],[3, 5, 7],[7, 9, 11]]
		power = 7
		answer = [[102881169, 150716907, 198552645],[159490607, 233647445, 307804283],[272709483, 399508521, 526307559]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=6)

	def testcase12(self):
		matrix_instance = MM(0)
		matrix = [[1, 1, 2],[2, 5, 1],[0, 1, 1]]
		power = 8
		answer = [[130811, 313870, 119925],[443080, 1063136, 406200],[92330, 221540, 84646]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=6)

	def testcase13(self):
		matrix_instance = MM(0)
		matrix = [[1, 0,0,0,1],[0, 0,0,0,3],[0, 0,0,3,0],[1, 0,0,0,0],[0, 1,0,0,0]]
		power = 26
		answer = [[1, 797161, 0, 0, 797161],[0, 1594323,0,0, 0],[3,797160,0,0,797160],[1, 265720, 0, 0, 797161],[0, 0, 0, 0, 1594323]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=10)

	def testcase14(self):
		matrix_instance = MM(0)
		matrix = [[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,-1,0],[0,0,0,0,0,1,0,0],[0,0,0,0,-1,0,0,0],[0,0,0,1,0,0,0,0], [0,0,1,0,0,0,0,0], [0,-1,0,0,0,0,0,0], [1,0,0,0,0,0,0,0]]
		power = 75
		answer = [[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,-1,0 ],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,-1,0,0,0,0],[0,0,1,0,0,0,0,0], [0,-1,0,0,0,0,0,0], [1,0,0,0,0,0,0,0]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=14)

	def testcase15(self):
		matrix_instance = MM(0)
		matrix = [[0,0,0,1],[0,0,1,1],[0,1,1,1],[1,1,1,1]]
		power = 10
		answer = [[2037, 3828, 5157, 5864],[3828, 7194, 9692, 11021],[5157, 9692, 13058, 14849],[5864, 11021, 14849, 16886]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=8)

	def testcase16(self):
		matrix_instance = MM(0)
		matrix = [[0,0,0,1],[0,0,0,1],[9,0,0,1],[9,0,0,1]]
		power = 11
		answer = [[442431, 0, 0 , 185329],[ 442431, 0, 0, 185329],[1667961, 0, 0, 627760],[1667961, 0, 0, 627760]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=8)

	def testcase17(self):
		matrix_instance = MM(0)
		matrix = [[0,0,0,0, 1],[0,0,0,2, 0],[0,0,1,0, 0],[1,0,0,1, 0],[1,0,1,0, 1]]
		power = 20
		answer = [[4181, 0, 10945, 0, 6765],[8362, 0, 21852, 2, 13528],[0, 0, 1, 0, 0],[6765, 0, 17690, 1, 10945],[6765, 0, 17710, 0, 10946]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=10)

	def testcase18(self):
		matrix_instance = MM(0)
		matrix = [[0, 0,0,0,0, 3],[0, 0,0,0,3, 0],[0, 0,0,3,0, 0],[4, 0,0,0,0, 0],[0, 4,0,0,0, 0], [0, 0,4,0,0, 0]]
		power = 16
		answer = [[429981696, 0,0,0,0, 0],[0, 429981696,0,0,0, 0 ],[0, 0,429981696,0,0, 0],[0, 0,0,429981696,0, 0],[0, 0,0,0,429981696, 0],[0, 0,0,0,0, 429981696]]
		self.assertEqual(matrix_instance.Call_multiplier(matrix,power),answer)
		self.assertTrue(matrix_instance.counter<=8)

if __name__ == '__main__':
    unittest.main()
