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
namespace PerceptronGUI
{
    
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {   //initialize perceptron object
        Perceptron net = new Perceptron(4);
        //expected value
        Node expectValue = new Node();
        public MainWindow()
        {
            InitializeComponent();
            upDateGUI();

            outputValue1.Text = "0";
        }

        public void upDateGUI()
        {
            //update input TextBlocks
            InputValue1.Text = "" + Math.Round(net.inputLayer[0].value, 2);
            InputValue2.Text = "" + Math.Round(net.inputLayer[1].value, 2);
            InputValue3.Text = "" + Math.Round(net.inputLayer[2].value, 2);
            InputValue4.Text = "" + Math.Round(net.inputLayer[3].value, 2);
            //update input weight TextBlocks
            InputWtValue1.Text = "" + Math.Round(net.weights[0].value, 2);
            InputWtValue2.Text = "" + Math.Round(net.weights[1].value, 2);
            InputWtValue3.Text = "" + Math.Round(net.weights[2].value, 2);
            InputWtValue4.Text = "" + Math.Round(net.weights[3].value, 2);
            //update output nodes TextBlock
            outputValue1.Text = "" + Math.Round(net.outputLayer.value, 2); ;
            
            //select pixel image
            string pixelName = "" + net.inputLayer[3].value + net.inputLayer[2].value + net.inputLayer[1].value + net.inputLayer[0].value + ".png";
            Pic.Source = new BitmapImage(new Uri(@"/assest/" + pixelName, UriKind.RelativeOrAbsolute));

            //determine expected value
            determineExpectValue();
        }

        //determines expected value based on input
        private void determineExpectValue()
        {
            double brightPixs = net.inputLayer[3].value + net.inputLayer[2].value + net.inputLayer[1].value + net.inputLayer[0].value;
            if (brightPixs < 3)
            {
                expectValue.value = 1;
            }
            else
            {
                expectValue.value = 0;
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
            else
            {

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
        //setup step button
        private void stepBtnClick(object sender, RoutedEventArgs e)
        {
        
            
            net.weightTrain(expectValue, Double.Parse(learnRateBox.Text));
            net.activate();
            upDateGUI();
         
        }
    }

   
}
