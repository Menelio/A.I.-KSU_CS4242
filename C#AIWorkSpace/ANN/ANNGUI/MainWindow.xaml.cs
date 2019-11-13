using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ANNLib;
namespace Assignment3GUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        //create Net object
        Net net = new Net(4, 2, 2);
        double[] expectValue= new double[2];
        public MainWindow()
        {
            InitializeComponent();
            upDateGUI();
            
        }
        /// <summary>
        /// Updates the gui with give nodes and weights
        /// </summary>
        /// <param name="inputs">Array of nodes for input</param>
        /// <param name="inputW">Array of weights for input weights</param>
        /// <param name="hidden">Array of nodes for hidden layer</param>
        /// <param name="outputW">Array of weights for output weights</param>
        /// /// <param name="outputs">Array of node for output</param>
        public void upDateGUI()
        {
            //update input TextBlocks
            InputValue1.Text = "" + Math.Round(net.inputLayer[0].value,2);
            InputValue2.Text = "" + Math.Round(net.inputLayer[1].value,2);
            InputValue3.Text = "" + Math.Round(net.inputLayer[2].value,2);
            InputValue4.Text = "" + Math.Round(net.inputLayer[3].value,2);
            //update input weight TextBlocks
            InputWtValue1.Text = "" + Math.Round(net.inputWeights[0].value,2);
            InputWtValue2.Text = "" + Math.Round(net.inputWeights[1].value,2);
            InputWtValue3.Text = "" + Math.Round(net.inputWeights[2].value,2);
            InputWtValue4.Text = "" + Math.Round(net.inputWeights[3].value,2);
            InputWtValue5.Text = "" + Math.Round(net.inputWeights[4].value,2);
            InputWtValue6.Text = "" + Math.Round(net.inputWeights[5].value,2);
            //update hidden layer nodes
            hiddenValue1.Text = "" + Math.Round(net.hiddenLayer[0].value,2);
            hiddenValue2.Text = "" + Math.Round(net.hiddenLayer[1].value,2);
            //update output Weight TextBlocks
            outputWtValue1.Text = "" + Math.Round(net.outputWeights[0].value,2);
            outputWtValue2.Text = "" + Math.Round(net.outputWeights[1].value,2);
            outputWtValue3.Text = "" + Math.Round(net.outputWeights[2].value,2);
            outputWtValue4.Text = "" + Math.Round(net.outputWeights[3].value,2);
            //update output nodes TextBlock
            outputValue1.Text = "" + Math.Round(net.outputLayer[0].value,2);
            outputValue2.Text = "" + Math.Round(net.outputLayer[1].value,2);

            //select pixel image
            string pixelName = ""+ net.inputLayer[3].value + net.inputLayer[2].value + net.inputLayer[1].value + net.inputLayer[0].value+".png";
            Pic.Source =new BitmapImage(new Uri(@"/assest/"+pixelName, UriKind.RelativeOrAbsolute));

            //determine expected value
            determineExpectValue();
        }
        //determines expected value based on input
        private void determineExpectValue() {
            double brightPixs = net.inputLayer[3].value + net.inputLayer[2].value + net.inputLayer[1].value + net.inputLayer[0].value;
            if (brightPixs < 3)
            {
                expectValue[0] = 1;
                expectValue[1] = 0;
            }
            else {
                expectValue[0] = 0;
                expectValue[1] = 1;
            }
        }

        //Button Events
        private void inputBtn1Clk(object sender, RoutedEventArgs e)
        {
            if (net.inputLayer[0].value == 0)
            {
                net.inputLayer[0].value = 1;
                upDateGUI();
            }
             else {
            
                 net.inputLayer[0].value = 0;
                upDateGUI();
            }
        }

        private void inputBtn2Clk(object sender, RoutedEventArgs e)
        {
            if (net.inputLayer[1].value == 0)
            {
                net.inputLayer[1].value = 1;
                upDateGUI();
            }
            else
            {

                net.inputLayer[1].value = 0;
                upDateGUI();
            }
        }

        private void inputBtn3Clk(object sender, RoutedEventArgs e)
        {
            if (net.inputLayer[2].value == 0)
            {
                net.inputLayer[2].value = 1;
                upDateGUI();
            }
            else
            {

                net.inputLayer[2].value = 0;
                upDateGUI();
            }
        }

        private void inputBtn4Clk(object sender, RoutedEventArgs e)
        {
            if (net.inputLayer[3].value == 0)
            {
                net.inputLayer[3].value = 1;
                upDateGUI();
            }
            else
            {

                net.inputLayer[3].value = 0;
                upDateGUI();
            }
        }

        //Step button click 
        private void stepBtnClick(object sender, RoutedEventArgs e)
        {
            net.propagateBackward(expectValue, Double.Parse(learnRateBox.Text));
            net.propagateForward();
            upDateGUI();
        }
    }
}
