package cn.bluethink.entity;

public class GraphInfo {
	/** ͼ����Ϣ��� */
    private Integer graphId;
    /** �û���� */
    private Integer userId;
	/** ͼ������ */
    private String graphType;
    /** ͼ����ɫ */
    private String graphColor;
    /** ͼ������ */
    private String graphName;
    /** ͼ���������� */
    private String graphContent;
    /** ͼ������ */
    private String graphData;
    
	public Integer getGraphId() {
		return graphId;
	}
	public void setGraphId(Integer graphId) {
		this.graphId = graphId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getGraphType() {
		return graphType;
	}
	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}
	public String getGraphColor() {
		return graphColor;
	}
	public void setGraphColor(String graphColor) {
		this.graphColor = graphColor;
	}
	public String getGraphName() {
		return graphName;
	}
	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}
	public String getGraphContent() {
		return graphContent;
	}
	public void setGraphContent(String graphContent) {
		this.graphContent = graphContent;
	}
	public String getGraphData() {
		return graphData;
	}
	public void setGraphData(String graphData) {
		this.graphData = graphData;
	}
	
	@Override
	public String toString() {
		return "GraphInfo [graphId=" + graphId + ", userId=" + userId + ", graphType=" + graphType + ", graphColor="
				+ graphColor + ", graphName=" + graphName + ", graphContent=" + graphContent + ", graphData="
				+ graphData + "]";
	}
	
	

}
