
// EX2View.h : CEX2View ��Ľӿ�
//

#pragma once


class CEX2View : public CView
{
protected: // �������л�����
	CEX2View();
	DECLARE_DYNCREATE(CEX2View)

// ����
public:
	CEX2Doc* GetDocument() const;

// ����
public:

// ��д
public:
	virtual void OnDraw(CDC* pDC);  // ��д�Ի��Ƹ���ͼ
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// ʵ��
public:
	virtual ~CEX2View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnRect();
};

#ifndef _DEBUG  // EX2View.cpp �еĵ��԰汾
inline CEX2Doc* CEX2View::GetDocument() const
   { return reinterpret_cast<CEX2Doc*>(m_pDocument); }
#endif

