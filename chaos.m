function chaos(a,generation,x0)
%  迭代模型 x(i+1) = a*x(i)*(1-x(i))
%  本函数用于演示震荡模型，产生蛛网模型的效果
%  初值x0 -(0,1)
%  增长系数a
%  迭代次数generation
%  说明：a - (1,3)时：x0从(0,1)出发都收敛至相同的周期1点（不动点）
%        a - (3,sqrt(6)+1) 时：x0从任意初值出发在周期2点之间震荡
%        a - (sqrt(6)+1,3.54409035)时：x0从任意初值出发在周期4点之间震荡
%        a - (3.54409035,4)时：开始进入混沌状态，对初值极其敏感
%        a - 4 时：混沌显的十分明显
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





