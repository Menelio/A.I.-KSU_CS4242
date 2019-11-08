using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    /// <summary>
    /// Nueral Net node
    /// </summary>
    public class Node
    {
        /// <summary>
        /// Value of input value, bias, or output value in this node
        /// </summary>
        public double value { get; set; }

        /// <summary>
        /// Arguement constructor
        /// </summary>
        /// <param name="value"> The double for the input value, bias, or output value</param>
        public Node(double inputVal)
        {
            this.value = inputVal;
        }

        /// <summary>
        /// No arguement default constructor
        /// </summary>
        public Node() {
            this.value = 0.0;
        }

        /// <summary>
        /// Copy Constructor
        /// </summary>
        /// <param name="node"> Node to be copied</param>
        public Node(Node node) {
            this.value = node.value;
        }
    }
}
