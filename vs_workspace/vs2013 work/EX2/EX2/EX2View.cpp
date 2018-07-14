
// EX2View.cpp : CEX2View 类的实现
//

#include "stdafx.h"
// SHARED_HANDLERS 可以在实现预览、缩略图和搜索筛选器句柄的
// ATL 项目中进行定义，并允许与该项目共享文档代码。
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
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
	ON_COMMAND(ID_32771, &CEX2View::OnRect)
END_MESSAGE_MAP()

// CEX2View 构造/析构

int MaxX, MaxY;

CEX2View::CEX2View()
{
	// TODO:  在此处添加构造代码


}

CEX2View::~CEX2View()
{
}

BOOL CEX2View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO:  在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CEX2View 绘制

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
	pDC->MoveTo(MaxX / 2, 0);//绘制坐标轴
	pDC->LineTo(MaxX / 2, MaxY);
	pDC->MoveTo(0, MaxY / 2);
	pDC->LineTo(MaxX, MaxY / 2);

	if (flag == 1)
	{
		pDC->Rectangle(200, 200, 400, 400);
		//RedrawWindow();
	}
	// TODO:  在此处为本机数据添加绘制代码
}


// CEX2View 打印

BOOL CEX2View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CEX2View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO:  添加额外的打印前进行的初始化过程
}

void CEX2View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO:  添加打印后进行的清理过程
}


// CEX2View 诊断

#ifdef _DEBUG
void CEX2View::AssertValid() const
{
	CView::AssertValid();
}

void CEX2View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CEX2Doc* CEX2View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CEX2Doc)));
	return (CEX2Doc*)m_pDocument;
}
#endif //_DEBUG


// CEX2View 消息处理程序


void CEX2View::OnRect()
{

	flag = 1;
	// TODO:  在此添加命令处理程序代码
}
