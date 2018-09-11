%% ˫������ֵ����ģ���˻��㷨
% ������ʽ��f(x) = (x-2)*(x+3)*(x+8)*(x-9)
% �㷨˼�룺ģ���˻𣬹���˼�壬ģ������˻�Ĺ���
% �����ڼ��ȵ��¶Ⱥܸ�ʱ�����ӵ������ܸߣ�״̬���ң�������ÿһ���ض����¶�
% ֻҪ���㹻��ʱ�䣬�����ᵽ�������¶���������͵�״̬������ϵͳ�����ԣ�����
% ���ƿ���һ��׼��̬���̡�ÿ���¶��¾��ж�ε������㣬����ܸ������Ž⣬��
% �����Ϊ���Ž⣬����һ���ĸ��ʽ����ӽ⣬���ӳ��ֲ����Ž⡣

clc;
clear;
tic;
initTemp = 1000;    % ��ʼ�¶�
minTemp = 1;        % �¶�����
iterL = 1000;       % �����µ�������
alpha = 0.95;       % ��ȴϵ��
k = 1;


initx = 10*(2*rand-1);      % ���������ʼ��
nowTemp = initTemp;         % ����ʱ���¶�
% �������ͼ��ͳ�ʼ��
xx = linspace(-10,10,300);  
yy = minfun(xx);
plot(xx,yy);
hold on;
plot(initx,minfun(initx),'o');
text(initx+0.3,minfun(initx),'��ʼ��');

while nowTemp > minTemp
    for i=1:iterL
        funVal = minfun(initx); % ������һ���ĺ���ָ
        xnew = initx + 2*rand - 1; % ������һ����ֵ��Χ��һ���µ�
        if xnew>=-10 || xnew <=10  % �Ƚ�������Ĵ�С��С�Ļ���������Ϊ��һ�������ŵ�
            funnew = minfun(xnew);
            if funnew < funVal
                initx = xnew;
            else
                p = exp(-(funnew-funVal)/(k*nowTemp)); % ��һ�����ʽ����ӽ�Ϊ���Ž�
                if rand < p
                    initx = xnew;
                end
            end
        end
    end
    nowTemp = alpha*nowTemp; % ����
end
initx
funVal
plot(initx,funVal,'*');
text(initx+0.3,minfun(initx),'���Ž�');
toc;

%%        



