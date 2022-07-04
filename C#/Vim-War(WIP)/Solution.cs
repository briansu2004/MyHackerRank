using System;
using System.CodeDom.Compiler;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;

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


    static List<string> skills = new List<string>();

    static string requirement;

    static int numSkills;

    public static int vimWar(List<string> _skills, string _requirement, int _numSkills)
    {

        int[] indexs = new int[_skills.Count];

        //generate index
        for (int i = 1; i <= _skills.Count; i++)
        {
            indexs[i - 1] = i;
        }

        numSkills = _numSkills;

        skills = _skills;

        requirement = _requirement;

        Console.WriteLine(requirement);

        Console.WriteLine(indexs.Count());

        PermuteCount(indexs);

        return keyCombinationList.Count;
    }

    static bool haveSkills(List<int> groupIndex)
    {
        int cs = 0;

        List<int> gr = new List<int>();

        foreach (var index in groupIndex)
        {
            char[] arm = skills[index - 1].ToCharArray();

            char[] reqs = requirement.ToCharArray();

            for (int s = 0; s < numSkills; s++)
            {

                if (arm[s] == reqs[s])
                {
                    if (!gr.Contains(index))
                    {
                        gr.Add(index);
                    }
                    cs++;
                }

                if (cs >= numSkills)
                {
                    return true;
                }
            }
        }
        return false;
    }

    static ArrayList keyCombinationList = new ArrayList();

    static bool uniqueSubGroupWithSkill(IList<IList<int>> combinations)
    {

        var list = new List<IList<int>>();

        bool haveFound = false;

        for (int i = 0; i < combinations.Count; i++)
        {

            var groupIndex = combinations[i];

            List<int> vIndex = new List<int>();

            foreach (var index in groupIndex)
            {
                vIndex.Add(index);

                bool res = haveSkills(vIndex);

                if (!res)
                    continue;

                string key = getKey(vIndex);

                if (!keyCombinationList.Contains(key))
                {
                    keyCombinationList.Add(key);

                    haveFound = true;

                    //Console.WriteLine("add unique " + key);
                }
                else
                {
                    //  Console.WriteLine("key present " + key);
                }
            }
        }
        return haveFound;
    }

    static String getKey(List<int> vIndex)
    {
        string key = string.Join("-", vIndex.OrderBy(x => x).ToList().Select(i => i.ToString()));

        return key;
    }

    static long permuteCount = 0;

    static bool haveMax = false;

    static void PermuteCount(int[] nums)
    {
        var list = new List<IList<int>>();
        DoPermuteCount(nums, 0, nums.Length - 1);
    }

    static void DoPermuteCount(int[] nums, int start, int end)
    {
        if (start == end)
        {
            IList<IList<int>> listCtrl = new List<IList<int>>();

            listCtrl.Add(new List<int>(nums));

            //PrintResult(nums);

            if (uniqueSubGroupWithSkill(listCtrl))
            {
                // Console.WriteLine("add unique");

                permuteCount++;

                if (nums.Length == skills[0].Length)
                    haveMax = true;
            }
        }
        else
        {
            for (var i = start; i <= end; i++)
            {
                Swap(ref nums[start], ref nums[i]);
                DoPermuteCount(nums, start + 1, end);
                Swap(ref nums[start], ref nums[i]);
            }
        }
    }

    static void Swap(ref int a, ref int b)
    {
        if (a == b)
            return;

        var temp = a;
        a = b;
        b = temp;
    }

    static void PrintResult(IList<IList<int>> lists)
    {
        Console.WriteLine("[");
        foreach (var list in lists)
        {
            Console.WriteLine($"    [{string.Join(',', list)}]");
        }
        Console.WriteLine("]");
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

        int result = Result.vimWar(skills, requirement, n);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
