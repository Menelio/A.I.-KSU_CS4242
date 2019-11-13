using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    /// <summary>
    /// Single output Percepotron
    /// </summary>
    public class Perceptron
    {
        /// <summary>
        /// Array of nodes for input layer
        /// </summary>
        public Node[] inputLayer { get; set; }

        /// <summary>
        /// Array of weights between input and output
        /// </summary>
        public Weight[] weights { get; set; }

        /// <summary>
        /// Array of nodes for output layer
        /// </summary>
        public Node outputLayer { get; set; }

        /// <summary>
        /// Argument Constructor 
        /// </summary>
        /// <param name="inputSize">Number of input nodes</param>
        public Perceptron(int inputSize) {  
            //Random number generator
            Random ran = new Random();
           
            //initialize input Nodes and weights
            this.inputLayer = new Node[inputSize];
            for (int i = 0; i < this.inputLayer.Length; i++) {
                this.inputLayer[i] = new Node();
                
            }
            this.weights = new Weight[inputSize];
            for (int i = 0; i < this.weights.Length; i++) {
                this.weights[i] = new Weight((ran.NextDouble() * 2) - 1);
            }
            //initialize outputlayer
            this.outputLayer = new Node();
        }

        /// <summary>
        /// Ativate the perceptron to generate output
        /// </summary>
        public void activate() {
            double temp = 1;// to prevent sticking
            Boolean noStick = true;
            for (int i = 0; i < inputLayer.Length; i++) {
                if (inputLayer[i].value > 0) {
                    noStick = false;
                    break;
                }
            }

            for (int i = 0; i < this.inputLayer.Length; i++) {
                if (noStick)
                {
                    this.outputLayer.value = this.outputLayer.value + (temp * this.weights[i].value);
                }
                else {
                    this.outputLayer.value = this.outputLayer.value + (this.inputLayer[i].value * this.weights[i].value);
                }
            }
         
            this.outputLayer.value = (Utils.sigmoid(outputLayer.value)*2)-1;
         
        }

        /// <summary>
        /// method to train weight base on difference between excepted output and actual output,
        /// and given learning
        /// </summary>
        /// <param name="expected">excpected output</param>
        /// <param name="learningRate">learning rate</param>
        public void weightTrain(Node expected, double learningRate) {
            double error =  expected.value - this.outputLayer.value;
            double[] adjustment = new double[this.inputLayer.Length];//delta to add to weights

            for (int i = 0; i < this.inputLayer.Length; i++) {
                adjustment[i] = (learningRate * error * this.inputLayer[i].value);
            }

            for (int i = 0; i < this.weights.Length; i++) {
                this.weights[i].value = this.weights[i].value + adjustment[i];

               
            }

            this.outputLayer.value = 0;
        }
    }
}
