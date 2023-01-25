import { useContext } from "react"
import { AppConfigContext } from "./AppConfigProvider"

export const useAppConfig = () => {
    return useContext(AppConfigContext);
}