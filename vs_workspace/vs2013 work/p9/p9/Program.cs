using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p9
{
    class Program
    {
        static void Main(string[] args)
        {
            string s1 = "s2";
            string s2 = "s1";
           var i= string.Compare(s1, s2);
           Console.WriteLine(i);
        }
    }
}
