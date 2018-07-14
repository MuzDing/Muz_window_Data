using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Collections;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            string s1, s2;
            s1 = "a";
            s2 = "b";
            s2=string.Format("{0}+{1}", s1, s2);
            Console.WriteLine(s1+s2);

            Person[] myPerson = new Person[2];
            myPerson[0] = new Person { s11 = "a", s22 = "b" };
            myPerson[1] = new Person { s11 = "c", s22 = "d" };
            Console.WriteLine(myPerson[0].ToString());
            Console.WriteLine(myPerson[1].ToString());

            string []    array = { 
                                                                "b","c","a"
                                                                };
   //         int []    array1 = new int [10];
        //    int [] a1 = (int[])array.Clone();
            Array.Sort(array);
            
            foreach (string i in array)
            {
                Console.WriteLine(i);
            }
        }
    }
}
