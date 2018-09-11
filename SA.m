%% 双谷最优值——模拟退火算法
% 函数形式：f(x) = (x-2)*(x+3)*(x+8)*(x-9)
% 算法思想：模拟退火，顾名思义，模拟金属退火的过程
% 金属在加热到温度很高时，分子的能量很高，状态很乱，但是在每一个特定的温度
% 只要有足够的时间，它都会到达所在温度下能量最低的状态，这是系统的特性，可以
% 近似看成一个准静态过程。每个温度下经行多次迭代运算，如果能更新最优解，则将
% 解更新为最优解，否则一定的概率接受劣解，以逃出局部最优解。

clc;
clear;
tic;
initTemp = 1000;    % 初始温度
minTemp = 1;        % 温度下限
iterL = 1000;       % 等温下迭代次数
alpha = 0.95;       % 冷却系数
k = 1;


initx = 10*(2*rand-1);      % 随机产生初始点
nowTemp = initTemp;         % 计算时的温度
% 绘出函数图像和初始点
xx = linspace(-10,10,300);  
yy = minfun(xx);
plot(xx,yy);
hold on;
plot(initx,minfun(initx),'o');
text(initx+0.3,minfun(initx),'初始点');

while nowTemp > minTemp
    for i=1:iterL
        funVal = minfun(initx); % 计算上一步的函数指
        xnew = initx + 2*rand - 1; % 在以上一函数值周围找一个新点
        if xnew>=-10 || xnew <=10  % 比较两个点的大小，小的话，将其作为下一步的最优点
            funnew = minfun(xnew);
            if funnew < funVal
                initx = xnew;
            else
                p = exp(-(funnew-funVal)/(k*nowTemp)); % 以一定概率接受劣解为最优解
                if rand < p
                    initx = xnew;
                end
            end
        end
    end
    nowTemp = alpha*nowTemp; % 降温
end
initx
funVal
plot(initx,funVal,'*');
text(initx+0.3,minfun(initx),'最优解');
toc;

%%        



