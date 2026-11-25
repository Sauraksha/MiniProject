package test;

class Library
{
	public void issueBook()
	{
		System.out.println("book issued");
	}
	public void returnBook()
	{
		System.out.println("book is returned");
	}
	public static void main(String[] args)
	{
		Library lab=new Library();
		lab.issueBook();
		lab.returnBook();
	}

}



