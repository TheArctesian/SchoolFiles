library(readxl)
x <- Copy_of_Temp_vs_thingy
#read data
y <- lm(GDPc~Temp, data = x) #linear reg
g2 <- x$GDPc^2 #GDP/c ^2
l <- lm(x$GDPc~x$Temp + g2) #second lin reg
summary(l)
p <- seq(0, 200000, 1) #fromat graph
d <- predict(l,list(uhh=p, uhh2=p^2)) #values for quad reg
plot(x$GDPc, x$Temp, pch=16, xlab="GDP/C (USD)", ylab="Temp(c)", cex.lab = 1.3, col = "red") #layout of graph
abline(lm(x$Temp~x$GDPc), col) #1st lin reg
abline(p, d ) #quad reg
abline(lm(x$Temp~x$GDPc + g2)) #2nd lin reg
summary(y)#lin reg values
