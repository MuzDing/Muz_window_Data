using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Factory
    {
        public static Product GetProduct(string arg)
        {
            Product product = null;
            if (arg.Equals("a"))
            {
                product = new ConcreteProductA();
            }
            else if (arg.Equals("b"))
            {
                
            }
            return product;
        }
    }
}
