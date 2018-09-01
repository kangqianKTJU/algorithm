function [optim, val] =  appoint(C)
% function [optim, val] =  appoint(C)
% ����������intlinprogʵ��ָ����������n*n��ָ������
%   -optiom ���Ž�
%   -val ����ֵ
%   -C ���þ���

n = length(C);
% ���þ���ת��Ϊ������ʽ
c = C(:);

%����Լ������
Aeq = zeros(2*n,n*n);
for i=1:n
    Aeq(i,1+n*(i-1):n*i)=ones(1,n); % �к�Ϊ1��Լ��
    Aeq(1+n:2*n,1+n*(i-1):n*i) = eye(n,n); % �к�Ϊ1��Լ��
end
beq = ones(2*n,1);
lb = zeros(n*n,1);
ub = ones(n*n,1);

intcon = 1:n*n;
[optim, val] = intlinprog(c,intcon,[],[],Aeq,beq,lb,ub);
optim = reshape(optim,n,n);





