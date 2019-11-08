using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    public class Weight
    {
        /// <summary>
        /// Value associated with this weight
        /// </summary>
        public double value { get; set; }

        /// <summary>
        /// Arguement constructor
        /// </summary>
        /// <param name="weight">Value associated with this weight</param>
        public Weight(double weight) {
            this.value = weight;
        }

        /// <summary>
        /// Default construcot, initializes with weight 0.
        /// </summary>
        public Weight() {
            this.value = 0;
        }

        /// <summary>
        /// Copy constructor
        /// </summary>
        /// <param name="weight"> Weight to be coppied</param>
        public Weight(Weight weightToCopy) {
            this.value = weightToCopy.value;
        }
    }
}
