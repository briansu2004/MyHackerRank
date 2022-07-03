using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{

    /*
     * Complete the 'vimWar' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY skills
     *  2. STRING requirement
     */

    public static int vimWar(List<string> skills, string requirement)
    {
        return 0;
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] firstMultipleInput = Console.ReadLine().TrimEnd().Split(' ');

        int n = Convert.ToInt32(firstMultipleInput[0]);

        int m = Convert.ToInt32(firstMultipleInput[1]);

        List<string> skills = new List<string>();

        for (int i = 0; i < n; i++)
        {
            string skillsItem = Console.ReadLine();
            skills.Add(skillsItem);
        }

        string requirement = Console.ReadLine();

        int result = Result.vimWar(skills, requirement);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
