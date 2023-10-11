import request from '@/utils/request'
import type { requestModel} from './type'

// 统一管理接口
enum API {
    SELECT = '/starDivination'
}


// 查询
export const starDivination = (data: any) =>
request.post<requestModel>(API.SELECT, data)