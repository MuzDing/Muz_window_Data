using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p2_2
{
    class MathLib
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="args"></param>
        public static void Main(string[] args)
        {

            var doctor = new {  FN="james",MN="T",LN="O'SULLIVEN"};
            Console.WriteLine(doctor.FN);

            int x,y;
            x=y=10;
            
            
            string FN= "李";
            string LN="鑫";
            test t = new test();
            t.Add(x,  y);
            t.fullname(FN, LN);
            Console.WriteLine("{0},{1} " , x, y);
            Console.WriteLine("{0}",t.fullname(LN:LN,FN:FN));


            Console.ReadLine();
        }
    }
    class test
    {
        public string fullname(string FN,string LN)
        {
            return FN + "" + LN;
        }
        public int Add(int x,  int y)
        {
            
            y++;
            return x + y;
        }
    }
}

