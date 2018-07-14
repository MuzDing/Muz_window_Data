using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace car
{
    class oooCarFactory:CarFactory
    {
        public car CreateCar()
        {
            car car = new OOOO();
            return car;
        }
    }
}
