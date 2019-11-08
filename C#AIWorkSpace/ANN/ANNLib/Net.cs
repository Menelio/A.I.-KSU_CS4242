using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ANNLib
{
    /// <summary>
    /// This class containd nueral net and associated functions
    /// </summary>
    public class Net
    {
        /// <summary>
        /// Array of nodes for input layer
        /// </summary>
        public Node[] inputLayer { get; set; }

        /// <summary>
        /// Array of weights between input and hidden layer
        /// </summary>
        public Weight[] inputWeights { get; set; }

        /// <summary>
        /// Array of nodes for input layer
        /// </summary>
        public Node[] hiddenLayer { get; set; }

        /// <summary>
        /// Array of weights between hidden and output layer
        /// </summary>
        public Weight[] outputWeights { get; set; }

        /// <summary>
        /// Array of nodes for output layer
        /// </summary>
        public Node[] outputLayer { get; set; }

        /// <summary>
        /// Arguement Constructor
        /// </summary>
        /// <param name="inputLayerSize"> Size of input layer</param>
        /// <param name="hiddenLayerSize">Size of hidden layer</param>
        /// <param name="outputLayerSize">Size of outputLayer</param>
        public Net(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {
            //Random number generator
            Random ran = new Random();

            //initialize Node arrays
            this.inputLayer = new Node[inputLayerSize];
            for (int i = 0; i < inputLayer.Length; i++)
            {
                inputLayer[i] = new Node();
            }

            this.hiddenLayer = new Node[hiddenLayerSize];
            for (int i = 0; i < hiddenLayer.Length; i++)
            {
                hiddenLayer[i] = new Node(); //gen random bias
            }
            this.outputLayer = new Node[outputLayerSize];
            for (int i = 0; i < outputLayer.Length; i++)
            {
                outputLayer[i] = new Node();
            }
            //initialize Weight arrays
            this.inputWeights = new Weight[(inputLayerSize * hiddenLayerSize)];
            for (int i = 0; i < inputWeights.Length; i++)
            {
                inputWeights[i] = new Weight( (ran.NextDouble() - .5));//gen random weight
            }
            this.outputWeights = new Weight[(outputLayerSize * hiddenLayerSize)];
            for (int i = 0; i < outputWeights.Length; i++)
            {
                outputWeights[i] = new Weight((ran.NextDouble() - .5));//gen random weight
            }

        }
        /// <summary>
        /// Propagate input forward through network
        /// </summary>
        public void propagateForward() {
            //set value of hiddenlayer  nodes
            for (int i = 0; i < hiddenLayer.Length; i++) {
                for (int j = 0; j < inputLayer.Length; j++) {
                    //(j * hiddenLayer.Length) +i
                    this.hiddenLayer[i].value = this.hiddenLayer[i].value + (this.inputLayer[j].value * 
                        this.inputWeights[(j *hiddenLayer.Length)+i].value );
                }
                this.hiddenLayer[i].value = Utils.sigmoid(this.hiddenLayer[i].value);
                this.hiddenLayer[i].value = Math.Round(this.hiddenLayer[i].value, 5);
                
            }
            for (int i = 0; i < outputLayer.Length; i++)
            {
                for (int j = 0; j < hiddenLayer.Length; j++)
                {
                    //(j * outputLayer.Length) +i
                    this.outputLayer[i].value = this.outputLayer[i].value + (this.hiddenLayer[j].value *
                        this.outputWeights[(j * outputLayer.Length) + i].value);
                }
              
                this.outputLayer[i].value = Utils.sigmoid(this.outputLayer[i].value);
                this.outputLayer[i].value = Math.Round(this.outputLayer[i].value, 5);
            }

            
        }

        public void propagateBackward(double[] expected, double learningRate ) {
            //error for outputlayer
            double[] outputError = new double[this.outputLayer.Length];
            //calculate output error
            for (int i = 0; i < outputError.Length; i++) {
                outputError[i] = (outputLayer[i].value) * (1 - outputLayer[i].value) * (expected[i] - outputLayer[i].value);
            }
           
            //error for hidden layer
            double[] hiddenLayerError = new double[this.hiddenLayer.Length];
            //calculate hidden layer error
            for ( int i=0,k = 0; i < hiddenLayer.Length; i++) {
                for (int j = 0; j < outputLayer.Length; j++, k++) {
                    hiddenLayerError[i] = hiddenLayerError[i] +
                    (outputWeights[k].value * outputError[j]);
                }
            }
           //finish calculation with formula hk(E)(1-hk(E) see slide 33 ppt AI-06-02
            for (int i = 0; i < hiddenLayerError.Length; i++) {
                if (hiddenLayer[i].value < .6) hiddenLayer[i].value = .6;//prevent sticking
                hiddenLayerError[i] = hiddenLayerError[i] *
                    (hiddenLayer[i].value * (1 - hiddenLayer[i].value));        
            }
            //adjusting output weights
            for (int i = 0,k=0; i < hiddenLayer.Length; i++) {
                for (int j = 0; j < outputError.Length; j++,k++) {

                    this.outputWeights[k].value = this.outputWeights[k].value +
                         (learningRate* outputError[j] * hiddenLayer[i].value);
               
                }
            }
            //adjust inputweights
            for (int i = 0, k = 0; i < inputLayer.Length; i++)
            {
                for (int j = 0; j < hiddenLayer.Length; j++, k++)
                {
                    double temp = inputWeights[k].value;

                    inputWeights[k].value = inputWeights[k].value +
                      (learningRate * hiddenLayerError[j] * inputLayer[i].value);
                }
            }

            for (int i = 0; i < this.outputLayer.Length; i++) {
               
                outputLayer[i].value = 0;
            }
            for (int i = 0; i < this.hiddenLayer.Length; i++)
            {
               hiddenLayer[i].value = 0;
            }
            
        }
    }
}
