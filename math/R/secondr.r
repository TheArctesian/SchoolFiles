library(readxl)
library(ggplot2)

tempvsthingy <- read_excel("~/Downloads/Temp vs Thingy (1).xlsx") #Upload the data
x <- lm(GDPc~Temp, data = tempvsthingy) #Create the linear regression
pl <- tbl_df(Copy_of_Temp_vs_thingy)

ggplot2(Copy_of_Temp_vs_thingy, aes(x = GDPc, y= Temp)) +
  geom_point()


