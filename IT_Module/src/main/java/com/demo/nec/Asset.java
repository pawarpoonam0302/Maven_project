package com.demo.nec;

/*
* this pojo class contains all the variables,constructor,getter,setter and
*  tostring method that will used to perform operations
*  by assetservice class
* */
public class Asset {

        private int assetId;
        private String assetType;
        private String assetName;
        private int assignedEmployeeId;
        private int requestId;
        private String status;
        private String issueDescription;


        public Asset() {
        }

        //constructor of class
        public Asset(int assetId, String assetType, String assetName, int assignedEmployeeId, int requestId, String status, String issueDescription) {
            this.assetId = assetId;
            this.assetType = assetType;
            this.assetName = assetName;
            this.assignedEmployeeId = assignedEmployeeId;
            this.requestId = requestId;
            this.status = status;
            this.issueDescription = issueDescription;
        }

        public int getAssetId() {
            return assetId;
        }

        public void setAssetId(int assetId) {

            if(assetId <= 0){
                System.out.println("please enter valid asset id");
            }
            else{
                this.assetId = assetId;
            }
        }

        public String getAssetType() {
            return assetType;
        }

        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }

        public String getAssetName() {
            return assetName;
        }

        public void setAssetName(String assetName) {
            this.assetName = assetName;
        }

        public int getAssignedEmployeeId() {
            return assignedEmployeeId;
        }

        public void setAssignedEmployeeId(int assignedEmployeeId) {
            if(assignedEmployeeId <= 0){
                System.out.println("please enter valid employee id");
            }
            else {
                this.assignedEmployeeId = assignedEmployeeId;
            }
        }

        public int getRequestId() {

            return requestId;
        }

        public void setRequestId(int requestId) {
            if(requestId <= 0){
                System.out.println("Enter valid request id");
            }
            this.requestId = requestId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIssueDescription() {
            return issueDescription;
        }

        public void setIssueDescription(String issueDescription) {
            this.issueDescription = issueDescription;
        }

        @Override
        public String toString() {
            return "Asset{" +
                    "assetId=" + assetId +
                    ", assetType='" + assetType + '\'' +
                    ", assetName='" + assetName + '\'' +
                    ", assignedEmployeeId=" + assignedEmployeeId +
                    ", requestId=" + requestId +
                    ", status='" + status + '\'' +
                    ", issueDescription='" + issueDescription + '\'' +
                    '}';
        }


}

