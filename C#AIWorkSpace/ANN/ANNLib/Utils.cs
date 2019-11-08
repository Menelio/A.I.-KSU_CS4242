using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    public class Utils
    {
        /// <summary>
        /// Sigmoid fuction for normilizing output
        /// </summary>
        /// <param name="n"> number to be normilized </param>
        /// <returns></returns>
        public static double sigmoid(double n)
        {
            return (1.0 / (1.0 + Math.Pow(Math.E, -n)));
        }

    }
}
