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

public class SentenceNode : AbstractNode
{
    private int m_value;

	public virtual AbstractNode AbstractNode
	{
		get;
		set;
	}

	public override int Interpret()
	{
        return m_value;
	}

	public SentenceNode(int value)
	{
        m_value = value;
	}

}

