using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Person
    {
        private string s1;
        private string s2;

        public string s11 { 
            get {return s1;}
            set { s1 = value; } 
        }
        public string s22 { 
            get {return s2;}
            set { s2 = value; } 
        }
        public override string ToString()
        {
            return string.Format("{0}+{1}", s1, s2);
        }
    }
}
