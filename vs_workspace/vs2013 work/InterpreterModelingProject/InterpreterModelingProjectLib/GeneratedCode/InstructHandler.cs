﻿//------------------------------------------------------------------------------
// <auto-generated>
//     此代码由工具生成
//     如果重新生成代码，将丢失对此文件所做的更改。
// </auto-generated>
//------------------------------------------------------------------------------
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class InstructHandler
{
    private AbstractNode m_node;

    /// <summary>
    /// 指令处理
    /// </summary>
    /// <param name="instruction"></param>
	public virtual void Handle(string instruction)
	{
        int i = 0;
        AbstractNode left = null;
        AbstractNode right = null;
        Stack<AbstractNode> stack = new Stack<AbstractNode>();  //新栈
        Queue<string> elementque = new Queue<string>();     //指令无乘除元素队列    
        string[] words = instruction.Split(' ');            //以空格划分
        //for (int i = 0; i < words.Length; i++)
        //{
        //    if (words[i].Equals("+") || words[i].Equals("-"))
        //    {
        //        left = stack.Pop();
        //        right = new SentenceNode(Convert.ToInt16(words[++i]));
        //        stack.Push(new AndNode(left, words[i-1], right));
        //    }
        //    else
        //    {
        //        left = new SentenceNode(Convert.ToInt16(words[i]));
        //        stack.Push(left);
        //    }
        //}
        //m_node = stack.Pop();
       
        //直到完整遍历队列
        while (i < words.Length)
        {
            //队列进队非乘除部分
            for (; (i + 1 < words.Length) && !(words[i + 1].Equals("*") || words[i + 1].Equals("/")); i++)
            {
                elementque.Enqueue(words[i]);   
            }

            if (i + 1 == words.Length)
            {
                elementque.Enqueue(words[i]);
                break;
            }
            //开始计算乘除
            for (; i < words.Length;i++ )
            {
                if (words[i].Equals("*") || words[i].Equals("/"))
                {
                    left = stack.Pop();
                    right = new SentenceNode(Convert.ToInt16(words[++i]));
                    stack.Push(new AndNode(left, words[i - 1], right));
                }
                else
                {
                    if (!(words[i].Equals("+") || words[i].Equals("-")))
                    {
                        left = new SentenceNode(Convert.ToInt16(words[i]));
                        stack.Push(left);
                    }
                    else
                    {
                        elementque.Enqueue(stack.Pop().Interpret().ToString());
                        break;
                    }
                }
            }
            //乘除到底
            if (i == words.Length)
            {
                elementque.Enqueue(stack.Pop().Interpret().ToString());
            }
        }
        string element = null;
        //处理去完成乘除运算后的队列的运算
        while (elementque.Count != 0)
        {
            element = elementque.Dequeue();
            if (element.Equals("+") || element.Equals("-"))
            {
                string sym = "" + element;
                left = stack.Pop();
                if(elementque.Count != 0)
                    element = elementque.Dequeue();
                right = new SentenceNode(Convert.ToInt16(element));
                stack.Push(new AndNode(left, sym, right));
            }
            else
            {
                left = new SentenceNode(Convert.ToInt16(element));
                stack.Push(left);
            }
        }
        m_node = stack.Pop();
	}

    /// <summary>
    /// 输出
    /// </summary>
    /// <returns></returns>
	public virtual int Output()
	{
        return m_node.Interpret();
	}

}
