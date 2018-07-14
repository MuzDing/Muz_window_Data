using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace car
{
    class Program
    {
        static void Main(string[] args)
        {
            car car;
            CarFactory carfactory;
            carfactory = new BwmCarFactory();
            car = carfactory.CreateCar();
            car.WriteLog();
            Console.Read();
        }
    }
}
