export default {
  getHomeData: () => {
    return {
      code: 200,
      data: {
        tableData: [
          {
            name: "工位1",
            totaBr: 30,
            ledBr: 20,
            outBr: 10,
            desirBr: 40,
          },
          {
            name: "工位2",
            totaBr: 50,
            ledBr: 30,
            outBr: 20,
            desirBr: 30,
          },
          {
            name: "工位3",
            totaBr: 20,
            ledBr: 0,
            outBr: 20,
            desirBr: 30,
          },
          {
            name: "工位4",
            totaBr: 20,
            ledBr: 10,
            outBr: 12,
            desirBr: 40,
          },
        ],
      },
    };
  },
};
