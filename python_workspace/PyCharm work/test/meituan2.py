n=input()
m_list=input().split(' ')
count=0
temp=0

def move(i):
    global count
    global temp
    for k in m_list:
        if int(k)==0:
            temp+=1
    if temp == len(m_list):
        if count % 2 == 0:
            print("Bob")
        else:
            print("Alice")
        return 0

    else:
        temp=0
        for i in range(len(m_list)):
            if m_list[i]==0:
                continue
            if m_list[i]==1:
                for j in range(i,len(m_list)):
                    if m_list[j]==1:
                        m_list[j]=0
                    else:
                        m_list[j]=1
        temp=i
        count+=1
    move(temp+1)
move(0)
