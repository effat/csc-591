#DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
class MatrixMultiplication:
	def __init__(self,cnter):
		self.counter=cnter

	def Call_multiplier(self,matrice,power):
		 #Write your code here to call Multiply_matrices lg(power) times.
		 #This method will have the 2-dimensional array and a number which specifies the power as inputs(Please see testcase file)
		 #This method should return the final matrice
		result = None
		while (power > 0):
			if power % 2 == 0:						# if power is even
				matrice = self.Multiply_matrices(matrice, matrice)	# Replace matrice by (matrice x matrice)
				power = power / 2
			else:								# if power is odd
				if result is None:
					result = matrice
				else:
					result = self.Multiply_matrices(result, matrice)	# result = result x matrice
				power = power - 1
		return result

	def Multiply_matrices(self,a,b):
		self.counter +=1
		#Write code here to multiply 2 matrices and return the resultant matrice
		N = len(a)	# Assume both a, b are square matrices of same dimension N
		c = [[0]*N for i in range(N)]		# Final output matrix size NxN, initialized to all 0
		for i in range(N):			# For each row of a
			for j in range(N):		# For each column of b
				for k in range(N):
					c[i][j] += a[i][k]*b[k][j]
		return c

