
// EX2View.cpp : CEX2View ���ʵ��
//

#include "stdafx.h"
// SHARED_HANDLERS ������ʵ��Ԥ��������ͼ������ɸѡ�������
// ATL ��Ŀ�н��ж��壬�����������Ŀ�����ĵ����롣
#ifndef SHARED_HANDLERS
#include "EX2.h"
#endif

#include "EX2Doc.h"
#include "EX2View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CEX2View

IMPLEMENT_DYNCREATE(CEX2View, CView)

BEGIN_MESSAGE_MAP(CEX2View, CView)
	// ��׼��ӡ����
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
	ON_COMMAND(ID_32771, &CEX2View::OnRect)
END_MESSAGE_MAP()

// CEX2View ����/����

int MaxX, MaxY;

CEX2View::CEX2View()
{
	// TODO:  �ڴ˴���ӹ������


}

CEX2View::~CEX2View()
{
}

BOOL CEX2View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO:  �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CEX2View ����

int flag;
void CEX2View::OnDraw(CDC* pDC)
{
	CEX2Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	CRect Rect;
	GetClientRect(&Rect);
	MaxX = Rect.right;
	MaxY = Rect.bottom;
	pDC->MoveTo(MaxX / 2, 0);//����������
	pDC->LineTo(MaxX / 2, MaxY);
	pDC->MoveTo(0, MaxY / 2);
	pDC->LineTo(MaxX, MaxY / 2);

	if (flag == 1)
	{
		pDC->Rectangle(200, 200, 400, 400);
		//RedrawWindow();
	}
	// TODO:  �ڴ˴�Ϊ����������ӻ��ƴ���
}


// CEX2View ��ӡ

BOOL CEX2View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CEX2View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO:  ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CEX2View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO:  ��Ӵ�ӡ����е��������
}


// CEX2View ���

#ifdef _DEBUG
void CEX2View::AssertValid() const
{
	CView::AssertValid();
}

void CEX2View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CEX2Doc* CEX2View::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CEX2Doc)));
	return (CEX2Doc*)m_pDocument;
}
#endif //_DEBUG


// CEX2View ��Ϣ�������


void CEX2View::OnRect()
{

	flag = 1;
	// TODO:  �ڴ���������������
}
