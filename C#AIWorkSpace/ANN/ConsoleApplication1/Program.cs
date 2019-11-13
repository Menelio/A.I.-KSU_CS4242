using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ANNLib;
namespace ConsoleApplication1
{
    class Program
    {
        
        static void Main(string[] args)
        {
            Net net = new Net(4, 2, 2);

            Perceptron p = new Perceptron(4);

            Node[] input = new Node[4];
            input[0]= new Node(0);
            input[1] = new Node(1);
            input[2] = new Node(0);
            input[3] = new Node(1);
            p.inputLayer = input;
            string l = "t";
            while (l.Equals("t"))
            {
                Console.WriteLine(p.outputLayer.value);
                //Console.WriteLine(p.inputLayer[0].value);
                p.weightTrain(new Node(1), .1);
                p.activate();
                
                l = Console.ReadLine();
            }
            //to stop
            Console.ReadKey();
        }
    }
}
