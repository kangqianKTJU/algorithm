function chaos(a,generation,x0)
%  ����ģ�� x(i+1) = a*x(i)*(1-x(i))
%  ������������ʾ��ģ�ͣ���������ģ�͵�Ч��
%  ��ֵx0 -(0,1)
%  ����ϵ��a
%  ��������generation
%  ˵����a - (1,3)ʱ��x0��(0,1)��������������ͬ������1�㣨�����㣩
%        a - (3,sqrt(6)+1) ʱ��x0�������ֵ����������2��֮����
%        a - (sqrt(6)+1,3.54409035)ʱ��x0�������ֵ����������4��֮����
%        a - (3.54409035,4)ʱ����ʼ�������״̬���Գ�ֵ��������
%        a - 4 ʱ�������Ե�ʮ������
n = generation;
x = zeros(1,n);
x(1) = x0;
x(2)=a*x(1).*(1-x(1));
clf;
subplot(2,1,1);
hold on;
plot([x(1),x(1)],[0,x(2)],'r-');
plot([x(1),x(2)],[x(2),x(2)],'r-');

for i=3:n
    x(i)=a*x(i-1).*(1-x(i-1));
    plot([x(i-2),x(i-2)],[x(i-2),x(i-1)],'r-');
    plot([x(i-1),x(i)],[x(i),x(i)],'r-');  
end
plot(x,x);
t=0:0.01:max(x);
plot(t,a*t.*(1-t),'k');
plot(x(n),x(n),'g*');
text(x(n),0.9*x(n),num2str(x(n)));
xlim([0,max(x)+0.1]);
hold off

subplot(2,1,2);
pdata = unique(x);
hist(x,length(pdata));
xlim([0,max(x)+0.1]);





