
// EX2View.h : CEX2View 类的接口
//

#pragma once


class CEX2View : public CView
{
protected: // 仅从序列化创建
	CEX2View();
	DECLARE_DYNCREATE(CEX2View)

// 特性
public:
	CEX2Doc* GetDocument() const;

// 操作
public:

// 重写
public:
	virtual void OnDraw(CDC* pDC);  // 重写以绘制该视图
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// 实现
public:
	virtual ~CEX2View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnRect();
};

#ifndef _DEBUG  // EX2View.cpp 中的调试版本
inline CEX2Doc* CEX2View::GetDocument() const
   { return reinterpret_cast<CEX2Doc*>(m_pDocument); }
#endif

