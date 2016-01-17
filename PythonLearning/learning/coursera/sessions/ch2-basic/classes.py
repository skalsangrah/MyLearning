class myClass():
	def method1(self):
		print ("myClass::my method1")
	def method2(self, someString):
		print ("myClass::my method2. " + someString)
	def method3(self):
		print ("myClass::my method3")

class anotherClass(myClass):  # Inheritence
	def method1(self):
		myClass.method1(self)
		print ("anotherClassClass::my method1")
	def method2(self):
		print ("anotherClass::my method2 ")

def main():
	c = myClass()
	c.method1()
	c.method2("This is someString")
	print ("------------------")
	c2 = anotherClass()
	c2.method1()
	c2.method2()
	c2.method3()

if __name__ == "__main__":
	main()
