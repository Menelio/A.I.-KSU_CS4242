using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    
    class InputNode
    {
        /// <summary>
        /// Value of input in this node
        /// </summary>
        public double inputVal { get; set; }

        /// <summary>
        /// Arguement constructor
        /// </summary>
        /// <param name="inputValue"> The double for the input value</param>
        public InputNode(double inputVal) {
            this.inputVal = inputVal;
        }
    }
}
