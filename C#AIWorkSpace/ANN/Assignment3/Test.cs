using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ANNLib;
namespace Assignment3
{
    class Test
    {
        static void Main(String[] args) {
            Console.WriteLine("Test class enter p for perceptron test or n for nueralnet test");
            if (Console.ReadLine() == "n")
            {
                Net net = new Net(4, 2, 2);
                Node[] input = new Node[4];
                input[0] = new Node(1);
                input[1] = new Node(1);
                input[2] = new Node(1);
                input[3] = new Node(1);
                net.inputLayer = input;

                double[] expected = { 1, 0 };
                //double[] expected = { 0.0 };
                double leaneringRate = 1;

                String l = "g'";
                int c = 0;
                while (true)
                {
                    Console.WriteLine("---------------------------------------epoch " + c);
                    l = Console.ReadLine();
                    if (l.Equals("q")) break;
                    net.propagateForward();

                    Console.WriteLine("=====" + net.outputLayer[0].value);
                    Console.WriteLine("=====" + net.outputLayer[1].value);

                    net.propagateBackward(expected, leaneringRate);
                    c++;
                }
                //to pause console
                Console.ReadKey();
            }
            else {

                Perceptron per = new Perceptron(4);

                Node[] input = new Node[4];
                input[0] = new Node(1.0);
                input[1] = new Node(-1.0);
                input[2] = new Node(-1.0);
                input[3] = new Node(-1.0);

                per.inputLayer = input;

                int c = 0;
                String l = "g'";
                while (true)
                {
                    per.activate();

                    l = Console.ReadLine();
                    if (l.Equals("q")) break;
                    Console.WriteLine("---------------------------------epoch " + c);
                    Console.WriteLine(per.outputLayer.value);

                    per.weightTrain(new Node(1), .1);
                    c++;

                }
            }
        }
    }

}
